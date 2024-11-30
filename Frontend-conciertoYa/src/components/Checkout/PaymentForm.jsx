import React from "react";
import { TextField, Grid, Typography } from "@material-ui/core";

export default function PaymentForm() {
return (
<React.Fragment>
    <Typography variant="h6" gutterBottom>
    Detalles de Pago
    </Typography>
    <Grid container spacing={3}>
    <Grid item xs={12} md={6}>
        <TextField required id="cardName" label="Nombre en la Tarjeta" fullWidth />
    </Grid>
    <Grid item xs={12} md={6}>
        <TextField required id="cardNumber" label="Número de Tarjeta" fullWidth />
    </Grid>
    </Grid>
</React.Fragment>
);
}
