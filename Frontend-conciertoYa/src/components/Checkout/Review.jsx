import React from "react";
import { List, ListItem, ListItemText, Typography } from "@material-ui/core";

export default function Review() {
return (
<React.Fragment>
    <Typography variant="h6" gutterBottom>
    Resumen de Pedido
    </Typography>
    <List disablePadding>
    <ListItem>
        <ListItemText primary="Producto 1" secondary="Descripción" />
        <Typography variant="body2">$10.00</Typography>
    </ListItem>
    <ListItem>
        <ListItemText primary="Envío" />
        <Typography variant="body2">$5.00</Typography>
    </ListItem>
    </List>
    <Typography variant="subtitle1">Total: $15.00</Typography>
</React.Fragment>
);
}
