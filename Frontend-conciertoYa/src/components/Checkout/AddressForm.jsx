import React from "react";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import TextField from "@mui/material/TextField";

export default function AddressForm() {
return (
<React.Fragment>
    <Typography variant="h6" gutterBottom>
    Información del Ticket
    </Typography>
    <Grid container spacing={3}>
    <Grid item xs={12}>
        <TextField
        required
        id="precio"
        name="precio"
        label="Precio del Ticket"
        fullWidth
        type="number"
        />
    </Grid>
    <Grid item xs={12}>
        <TextField
        id="descuento"
        name="descuento"
        label="Descuento (%)"
        fullWidth
        type="number"
        />
    </Grid>
    <Grid item xs={12}>
        <TextField
        required
        id="cliente"
        name="cliente"
        label="Nombre del Cliente"
        fullWidth
        />
    </Grid>
    <Grid item xs={12}>
        <TextField
        required
        id="asiento"
        name="asiento"
        label="Número de Asiento"
        fullWidth
        />
    </Grid>
    </Grid>
</React.Fragment>
);
}
