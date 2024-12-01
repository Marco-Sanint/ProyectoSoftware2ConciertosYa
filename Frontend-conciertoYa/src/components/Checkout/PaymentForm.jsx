import React from "react";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import TextField from "@mui/material/TextField";

export default function PaymentForm() {
return (
<React.Fragment>
    <Typography variant="h6" gutterBottom>
    Detalles de Pago
    </Typography>
    <Grid container spacing={3}>
    <Grid item xs={12}>
        <TextField
        required
        id="metodoPago"
        name="metodoPago"
        label="Método de Pago"
        fullWidth
        />
    </Grid>
    </Grid>
</React.Fragment>
);
}
