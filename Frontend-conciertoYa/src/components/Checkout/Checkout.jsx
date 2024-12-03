import React, { useState, useEffect } from "react";
import {
CssBaseline,
AppBar,
Toolbar,
Paper,
Stepper,
Step,
StepLabel,
Button,
Typography,
Grid,
TextField,
Select,
MenuItem,
InputLabel,
FormControl,
} from "@mui/material";
import jsPDF from "jspdf";
import "jspdf-autotable";
import { useNavigate } from "react-router-dom";
import "./Checkout.css";

const steps = ["Confirmar Información", "Seleccionar Método de Pago", "Revisar Pedido"];

function getStepContent(
step,
cliente,
asientoSeleccionado,
descuento,
precio,
metodoPago,
setMetodoPago,
generarCodigo,
codigoPago
) {
const precioFinal = precio - (precio * descuento) / 100;

switch (step) {
case 0:
    return (
    <Grid container spacing={3}>
        <Grid item xs={12}>
        <Typography variant="h6" gutterBottom>
            Información del Cliente
        </Typography>
        <TextField label="Nombre" value={cliente.nombre} fullWidth disabled />
        <TextField label="ID del Cliente" value={cliente.id} fullWidth disabled />
        <TextField label="Correo Electrónico" value={cliente.email} fullWidth disabled />
        <TextField label="Número de Teléfono" value={cliente.telefono} fullWidth disabled />
        </Grid>
        <Grid item xs={12}>
        <Typography variant="h6" gutterBottom>
            Confirmación del Asiento
        </Typography>
        <TextField label="Número de Asiento" value={asientoSeleccionado} fullWidth disabled />
        </Grid>
    </Grid>
    );
case 1:
    return (
    <Grid container spacing={3}>
        <Grid item xs={12}>
        <FormControl fullWidth>
            <InputLabel>Método de Pago</InputLabel>
            <Select
            value={metodoPago}
            onChange={(e) => {
                setMetodoPago(e.target.value);
                if (e.target.value === "Punto Físico") {
                generarCodigo(); // Generar código de pago
                }
            }}
            >
            <MenuItem value="Punto Físico">Punto Físico</MenuItem>
            <MenuItem value="Transferencia">Transferencia (PSE)</MenuItem>
            </Select>
        </FormControl>
        </Grid>
        {metodoPago === "Punto Físico" && (
        <Grid item xs={12}>
            <Typography variant="body1">
            Código de Pago en Punto Físico: <strong>{codigoPago}</strong>
            </Typography>
        </Grid>
        )}
    </Grid>
    );
case 2:
    return (
    <Grid container spacing={3}>
        <Grid item xs={12}>
        <Typography variant="h6" gutterBottom>
            Resumen del Pedido
        </Typography>
        <Typography>Precio Original: ${precio.toFixed(2)}</Typography>
        <Typography>Descuento: {descuento}%</Typography>
        <Typography>Total a Pagar: ${precioFinal.toFixed(2)}</Typography>
        </Grid>
    </Grid>
    );
default:
    throw new Error("Paso desconocido");
}
}

export default function Checkout() {
const [activeStep, setActiveStep] = useState(0);
const [cliente, setCliente] = useState({
id: "12",
nombre: "Jhonatan Tamayo",
email: "jhonatan@example.com",
telefono: "12345",
});
const [asientoSeleccionado, setAsientoSeleccionado] = useState("");
const [metodoPago, setMetodoPago] = useState("");
const [codigoPago, setCodigoPago] = useState("");
const [descuento, setDescuento] = useState(10); // Descuento aplicado
const [precio, setPrecio] = useState(100); // Precio original
const navigate = useNavigate(); // Hook para navegación

useEffect(() => {
const asientoSeleccionado = localStorage.getItem("asientoSeleccionado") || "A1";
setAsientoSeleccionado(asientoSeleccionado);
}, []);

const handleNext = () => {
if (metodoPago === "Transferencia") {
    window.open("https://simulacion-pse.com", "_blank"); // Simular redirección a PSE
    setTimeout(() => {
    setActiveStep(activeStep + 1);
    if (activeStep === steps.length - 1) {
        generarFactura(); // Generar factura al final
    }
    }, 2000);
} else {
    setActiveStep(activeStep + 1);
    if (activeStep === steps.length - 1) {
    generarFactura(); // Generar factura al final
    }
}
};

const handleBack = () => {
setActiveStep(activeStep - 1);
};

const generarCodigo = () => {
const codigo = Math.floor(100000 + Math.random() * 900000).toString();
setCodigoPago(codigo);
};

const generarFactura = () => {
const doc = new jsPDF();
doc.setFontSize(16);
doc.text("Factura de Compra", 20, 20);
doc.autoTable({
    startY: 30,
    head: [["Campo", "Valor"]],
    body: [
    ["Nombre", cliente.nombre],
    ["ID del Cliente", cliente.id],
    ["Correo Electrónico", cliente.email],
    ["Teléfono", cliente.telefono],
    ["Número de Asiento", asientoSeleccionado],
    ["Método de Pago", metodoPago],
    ["Código de Pago", metodoPago === "Punto Físico" ? codigoPago : "N/A"],
    ["Precio Original", `$${precio.toFixed(2)}`],
    ["Descuento", `${descuento}%`],
    ["Total a Pagar", `$${(precio - (precio * descuento) / 100).toFixed(2)}`],
    ],
});
doc.save(`Factura_${cliente.id}.pdf`);
};

const handleInicio = () => {
navigate("/"); // Redirigir al Home
};

return (
<React.Fragment>
    <CssBaseline />
    <AppBar position="relative" color="default">
    <Toolbar>
        <Typography variant="h6" color="inherit" noWrap>
        Pasarela de Pago - ConciertoYa
        </Typography>
    </Toolbar>
    </AppBar>
    <main className="layout">
    <Paper className="paper">
        <Typography component="h1" variant="h4" align="center">
        Checkout
        </Typography>
        <Stepper activeStep={activeStep} className="stepper">
        {steps.map((label) => (
            <Step key={label}>
            <StepLabel>{label}</StepLabel>
            </Step>
        ))}
        </Stepper>
        <React.Fragment>
        {activeStep === steps.length ? (
            <React.Fragment>
            <Typography variant="h5" align="center" className="typographyFinal">
                ¡Gracias por tu pedido! La factura ha sido generada.
            </Typography>
            <Button
                variant="contained"
                color="primary"
                onClick={handleInicio}
                className="nextButton"
            >
                Ir a Inicio
            </Button>
            </React.Fragment>
        ) : (
            <React.Fragment>
            {getStepContent(
                activeStep,
                cliente,
                asientoSeleccionado,
                descuento,
                precio,
                metodoPago,
                setMetodoPago,
                generarCodigo,
                codigoPago
            )}
            <div className="buttonContainer">
                {activeStep !== 0 && (
                <Button onClick={handleBack} className="backButton">
                    Atrás
                </Button>
                )}
                <Button
                variant="contained"
                color="primary"
                onClick={handleNext}
                className="nextButton"
                >
                {activeStep === steps.length - 1 ? "Realizar Pedido" : "Siguiente"}
                </Button>
            </div>
            </React.Fragment>
        )}
        </React.Fragment>
    </Paper>
    </main>
</React.Fragment>
);
}
