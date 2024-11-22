import React, { useState } from "react";
import Draggable from "react-draggable";
import "./SeatSelection.css"; // Archivo CSS

const SeatSelection = () => {
const [seats, setSeats] = useState([
{ id: 1, name: "VIP 1", price: 100, selected: false, position: { top: "30%", left: "40%" } },
{ id: 2, name: "VIP 2", price: 100, selected: false, position: { top: "35%", left: "50%" } },
{ id: 3, name: "General 1", price: 50, selected: false, position: { top: "50%", left: "20%" } },
]);

const [cart, setCart] = useState([]);

const handleDrop = (seatId) => {
const seat = seats.find((s) => s.id === seatId);
if (seat && !seat.selected) {
    setSeats((prev) => prev.map((s) => (s.id === seatId ? { ...s, selected: true } : s)));
    setCart((prev) => [...prev, seat]);
}
};

const calculateTotal = () => {
return cart.reduce((sum, seat) => sum + seat.price, 0);
};

return (
<div className="page-container">
    {/* Detalles del evento */}
    <section className="event-details">
    <img src="/imagenes/event-image.jpg" alt="Evento" className="event-image" />
    <div className="event-info">
        <h1>Concierto de XYZ</h1>
        <p>Fecha: 25 de diciembre de 2024</p>
        <p>Ubicación: Gran Arena</p>
    </div>
    </section>

    {/* Selección de asientos */}
    <section className="seat-selection">
    <h2>Selección de Asientos</h2>
    <div className="seat-map-container">
        <img src="/imagenes/seating-circular.jpg" alt="Mapa de asientos" className="seat-map" />

        {/* Asientos */}
        {seats
        .filter((seat) => !seat.selected)
        .map((seat) => (
            <Draggable key={seat.id} onStop={() => handleDrop(seat.id)}>
            <div
                className="seat-location"
                style={{ top: seat.position.top, left: seat.position.left }}
            >
                {seat.name} <br /> ${seat.price}
            </div>
            </Draggable>
        ))}
    </div>
    </section>

    {/* Resumen del pedido */}
    <section className="cart-summary">
    <h2>Resumen del Pedido</h2>
    <div className="cart">
        {cart.length > 0 ? (
        <>
            {cart.map((item) => (
            <div key={item.id} className="cart-item">
                {item.name} - ${item.price}
            </div>
            ))}
            <p className="total">Total: ${calculateTotal()}</p>
        </>
        ) : (
        <p>No hay asientos seleccionados</p>
        )}
    </div>
    </section>
</div>
);
};

export default SeatSelection;
