import React, { useState } from "react";
import {CssBaseline,AppBar,Toolbar,Paper,Stepper,Step,StepLabel,Button,Typography,
} from "@material-ui/core";
import AddressForm from "./AddressForm";
import PaymentForm from "./PaymentForm";
import Review from "./Review";
import "./Checkout.css";
const steps = ["Dirección de Envío", "Detalles de Pago", "Revisar Pedido"];

function getStepContent(step) {
switch (step) {
case 0:
    return <AddressForm />;
case 1:
    return <PaymentForm />;
case 2:
    return <Review />;
default:
    throw new Error("Paso desconocido");
}
}

export default function Checkout() {
    const [activeStep, setActiveStep] = useState(0);

const handleNext = () => {
setActiveStep(activeStep + 1);
};

const handleBack = () => {
setActiveStep(activeStep - 1);
};

return (
<React.Fragment>
    <CssBaseline />
    <AppBar position="absolute" color="default">
    <Toolbar>
        <Typography variant="h6" color="inherit" noWrap>
        Pasarela de Pago
        </Typography>
    </Toolbar>
    </AppBar>
    <main>
    <Paper>
        <Typography component="h1" variant="h4" align="center">
        Checkout
        </Typography>
        <Stepper activeStep={activeStep}>
        {steps.map((label) => (
            <Step key={label}>
            <StepLabel>{label}</StepLabel>
            </Step>
        ))}
        </Stepper>
        <React.Fragment>
        {activeStep === steps.length ? (
            <Typography variant="h5" align="center">
            Gracias por tu pedido.
            </Typography>
        ) : (
            <React.Fragment>
            {getStepContent(activeStep)}
            <div>
                {activeStep !== 0 && (
                <Button onClick={handleBack}>Atrás</Button>
                )}
                <Button
                variant="contained"
                color="primary"
                onClick={handleNext}
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

