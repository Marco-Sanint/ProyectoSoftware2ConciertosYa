import React, { useState } from "react";
import Draggable from "react-draggable";
import "./SeatSelection.css";

const SeatSelection = () => {
const [seats, setSeats] = useState([
{ id: 1, name: "VIP 1", price: 200, selected : false, position: { top: "73%", left: "45%" } },
{ id: 2, name: "VIP 1", price: 200, selected : false, position: { top: "40%", left: "25.6%" } },
{ id: 3, name: "VIP 1", price: 200, selected : false, position: { top: "73%", left: "66%" } },
{ id: 4, name: "Platino ", price: 150, selected : false,position: { top: "87%", left: "25.8%" } },
{ id: 5, name: "Platino ", price: 150, selected : false,position: { top: "87%", left: "45%" } },
{ id: 5, name: "Platino ", price: 150, selected : false,position: { top: "87%", left: "64.8%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "63%", left: "14%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "75%", left: "12%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "87%", left: "14%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "99%", left: "21%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "108%", left: "33%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "20%", left: "30%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "20%", left: "30%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "20%", left: "30%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "20%", left: "30%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "20%", left: "30%" } },
{ id: 6, name: "General 1", price: 150,selected : false , position: { top: "20%", left: "30%" } },

{ id: 7, name: "General 2", price: 100, selected : false, position: { top: "10%", left: "60%" } },
]);

const [cart, setCart] = useState([]);

const handleDrop = (seatId) => {
const seat = seats.find((s) => s.id === seatId);
if (seat && !cart.includes(seat)) {
    setSeats((prev) =>prev.map((s) => (s.id === seatId ? { ...s, selected: true } : s)));
    setCart((prev) => [...prev, seat]);
}
};

return (
<div className="page-container">
    <header className="header">
    <div className="logo">🎟️ ConciertoYa</div>
    <nav className="nav">
        <a href="#inicio">Inicio</a>
        <a href="#eventos">Eventos</a>
        <a href="#contacto">Contacto</a>
        <button className="login-btn">Iniciar Sesión</button>
    </nav>
    </header>

    <main className="main-content">
    <h1>Selección de Asientos</h1>
    <div className="event-info">
        <h2>Concierto de Banda XYZ</h2>
        <p>Fecha: 25 de Noviembre, 2024</p>
        <p>Lugar: Gran Arena Ciudad</p>
    </div>

    <div className="seat-selection">
        <div className="seat-map-container">
        <img
            src="/imagenes/seating-circular.jpg"
            alt="Mapa de asientos"
            className="seat-map"
        />

        {/* Mostrar precios en la posición de cada localidad */}
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
    </div>

    {/* Carrito */}
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
        <button className="pay-btn">Proceder al Pago</button>
    </div>
    </main>

    <footer className="footer">
    <p>© 2024 ConciertoYa. Todos los derechos reservados.</p>
    <div className="social-links">
        <a href="https://facebook.com">Facebook</a>
        <a href="https://instagram.com">Instagram</a>
        <a href="https://twitter.com">Twitter</a>
    </div>
    </footer>
</div>
);
};

export default SeatSelection;
