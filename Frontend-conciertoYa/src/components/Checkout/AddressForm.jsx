import React from "react";
import { TextField, Grid, Typography } from "@material-ui/core";

export default function AddressForm() {
return (
<React.Fragment>
    <Typography variant="h6" gutterBottom>
    Dirección de Envío
    </Typography>
    <Grid container spacing={3}>
    <Grid item xs={12} sm={6}>
        <TextField required id="firstName" label="Nombre" fullWidth />
    </Grid>
    <Grid item xs={12} sm={6}>
        <TextField required id="lastName" label="Apellido" fullWidth />
    </Grid>
    <Grid item xs={12}>
        <TextField required id="address1" label="Dirección" fullWidth />
    </Grid>
    <Grid item xs={12} sm={6}>
        <TextField required id="city" label="Ciudad" fullWidth />
    </Grid>
    <Grid item xs={12} sm={6}>
        <TextField id="state" label="Estado/Provincia/Región" fullWidth />
    </Grid>
    </Grid>
</React.Fragment>
);
}
