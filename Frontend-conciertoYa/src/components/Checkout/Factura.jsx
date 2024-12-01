import React from 'react';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

export default function Factura({ facturaData }) {
const generarFacturaPDF = () => {
const doc = new jsPDF();

// Encabezado
doc.setFontSize(18);
doc.text("Factura de Compra", 14, 20);

// Información de la factura
doc.setFontSize(12);
doc.text(`Número de Factura: ${facturaData.factura_id}`, 14, 30);
doc.text(`Fecha de Emisión: ${facturaData.fechaEmision}`, 14, 36);
doc.text(`Cliente: ${facturaData.cliente.nombre} (ID: ${facturaData.cliente.cedula})`, 14, 42);
doc.text(`Método de Pago: ${facturaData.metodoPago}`, 14, 48);

// Tabla con detalles de los tickets
const tickets = facturaData.tickets.map(ticket => [
    ticket.ticket_id,
    ticket.fechaCompra,
    ticket.asiento.numero,
    ticket.precio.toFixed(2),
    ticket.descuento.toFixed(2),
    ticket.precioConDescuento.toFixed(2),
]);

doc.autoTable({
    head: [['ID Ticket', 'Fecha Compra', 'Asiento', 'Precio', 'Descuento', 'Precio Final']],
    body: tickets,
    startY: 60,
});

// Total
const totalY = doc.previousAutoTable.finalY + 10;
doc.text(`Total a Pagar: ${facturaData.total.toFixed(2)} USD`, 14, totalY);

// Generar el PDF
doc.save(`Factura_${facturaData.factura_id}.pdf`);
};

return (
<div>
    <button onClick={generarFacturaPDF}>Generar Factura PDF</button>
</div>
);
}
