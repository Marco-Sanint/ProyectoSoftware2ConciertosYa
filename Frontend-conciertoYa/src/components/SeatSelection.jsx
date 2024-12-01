import React, { useState } from "react";
import Draggable from "react-draggable";
import { useNavigate } from 'react-router-dom';
import "./SeatSelection.css";
import Checkout from "./Checkout/Checkout";

const SeatSelection = ({ setAsientoSeleccionado }) => {
const [seats, setSeats] = useState([
{ id: 1, name: "VIP 1", price: 200, selected: false, position: { top: "73%", left: "45%" } },
{ id: 2, name: "VIP 1", price: 200, selected: false, position: { top: "40%", left: "25.6%" } },
{ id: 3, name: "VIP 1", price: 200, selected: false, position: { top: "73%", left: "66%" } },
{ id: 4, name: "Platino", price: 150, selected: false, position: { top: "87%", left: "25.8%" } },
{ id: 5, name: "Platino", price: 150, selected: false, position: { top: "87%", left: "45%" } },
{ id: 6, name: "General 1", price: 100, selected: false, position: { top: "63%", left: "14%" } },
]);

const navigate = useNavigate();
const [cart, setCart] = useState([]);

// Maneja la selección de asientos
const handleDrop = (seatId) => {
const seat = seats.find((s) => s.id === seatId);
if (seat && !seat.selected) {
    setSeats((prev) => prev.map((s) => (s.id === seatId ? { ...s, selected: true } : s)));
    setCart((prev) => [...prev, seat]);
}
};

const handleNext = () => {
if (cart.length > 0) {
    setAsientoSeleccionado(cart); // Guardar los asientos seleccionados
    navigate('/checkout'); // Navegar a la pasarela de pago
}
};

return (
<div className="page-container">
    <header className="header">
    <div className="logo">🎟️ ConciertoYa</div>
    </header>

    <main className="main-content">
    <h1>Selección de Asientos</h1>
    <div className="seat-selection">
        <div className="seat-map-container">
        <img src="/imagenes/seating-circular.jpg" alt="Mapa de asientos" className="seat-map" />
        {seats.filter((seat) => !seat.selected).map((seat) => (
            <Draggable key={seat.id} onStop={() => handleDrop(seat.id)}>
            <div className="seat-location" style={{ top: seat.position.top, left: seat.position.left }}>
                {seat.name} <br /> ${seat.price}
            </div>
            </Draggable>
        ))}
        </div>
    </div>

    <div className="cart">
        <h3>Carrito</h3>
        {cart.length > 0 ? (
        cart.map((item) => (
            <div key={item.id} className="cart-item">
            {item.name} - ${item.price}
            </div>
        ))
        ) : (
        <p>No hay asientos seleccionados</p>
        )}
        <button onClick={Checkout} className="pay-btn" disabled={cart.length === 0}>
        Proceder al Pago
        </button>
    </div>
    </main>
</div>
);
};

export default SeatSelection;
