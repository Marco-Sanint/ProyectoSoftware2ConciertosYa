import React from "react";
import Typography from "@mui/material/Typography";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemText from "@mui/material/ListItemText";

export default function Review() {
return (
<React.Fragment>
    <Typography variant="h6" gutterBottom>
    Resumen de la Compra
    </Typography>
    <List disablePadding>
    <ListItem>
        <ListItemText primary="Ticket" secondary="Asiento 10" />
        <Typography variant="body2">$100.00</Typography>
    </ListItem>
    <ListItem>
        <ListItemText primary="Descuento" />
        <Typography variant="body2">10%</Typography>
    </ListItem>
    <ListItem>
        <ListItemText primary="Total" />
        <Typography variant="body2">$90.00</Typography>
    </ListItem>
    </List>
</React.Fragment>
);
}
