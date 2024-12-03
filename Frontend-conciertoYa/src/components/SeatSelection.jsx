import React, { useState } from "react";
import Draggable from "react-draggable";
import { useNavigate } from 'react-router-dom';
import "./SeatSelection.css";
import Checkout from "./Checkout/Checkout";
import Header from "./Header";
import Footer from "./Footer";
import { FaTicketAlt } from 'react-icons/fa';


const SeatSelection = ({ setAsientoSeleccionado }) => {
const [seats, setSeats] = useState([
{ id: 1, name: "VIP 1", price: 500, selected: false, position: { top: "46.5%", left: "31.8%" } },
{ id: 2, name: "VIP 1", price: 500, selected: false, position: { top: "46.5%", left: "47.1%" } },
{ id: 3, name: "VIP 1", price: 500, selected: false, position: { top: "46.5%", left: "63.2%" } },
{ id: 4, name: "Platino", price: 300, selected: false, position: { top: "66.7%", left: "31.85%" } },
{ id: 5, name: "Platino", price: 300, selected: false, position: { top: "70%", left: "46.66%" } },
{ id: 6, name: "Platino", price: 300, selected: false, position: { top: "67.2%", left: "62.235%" } },

{ id: 7, name: "General1", price: 150, selected: false, position: { top: "31.5%", left: "23%" } },
{ id: 8, name: "General1", price: 150, selected: false, position: { top: "49.5%", left: "21.3%" } },
{ id: 9, name: "General1", price: 150, selected: false, position: { top: "69%", left: "22.8%" } },
{ id: 10, name: "General1", price: 150, selected: false, position: { top: "87.5%", left: "28%" } },
{ id: 11, name: "General1", price: 150, selected: false, position: { top: "100.5%", left: "37.5%" } },
{ id: 12, name: "General1", price: 150, selected: false, position: { top: "104.5%", left: "49%" } },
{ id: 13, name: "General1", price: 150, selected: false, position: { top: "97.5%", left: "60.2%" } },
{ id: 14, name: "General1", price: 150, selected: false, position: { top: "82%", left: "68%" } },
{ id: 15, name: "General1", price: 150, selected: false, position: { top: "64%", left: "72%" } },
{ id: 16, name: "General1", price: 150, selected: false, position: { top: "45%", left: "72.5%" } },
{ id: 17, name: "General1", price: 150, selected: false, position: { top: "27%", left: "70.2%" } },

{ id: 18, name: "General2", price: 100, selected: false, position: { top: "33.5%", left: "14.8%" } },
{ id: 19, name: "General2", price: 100, selected: false, position: { top: "52.5%", left: "13.78%" } },
{ id: 20, name: "General2", price: 100, selected: false, position: { top: "74.9%", left: "15.8%" } },
{ id: 21, name: "General2", price: 100, selected: false, position: { top: "98.5%", left: "22.6%" } },
{ id: 22, name: "General2", price: 100, selected: false, position: { top: "116%", left: "35.2%" } },
{ id: 23, name: "General2", price: 100, selected: false, position: { top: "120.2%", left: "50.5%" } },
{ id: 24, name: "General2", price: 100, selected: false, position: { top: "111%", left: "64%" } },
{ id: 25, name: "General2", price: 100, selected: false, position: { top: "89.2%", left: "75%" } },
{ id: 26, name: "General2", price: 100, selected: false, position: { top: "67.7%", left: "79%" } },
{ id: 27, name: "General2", price: 100, selected: false, position: { top: "48.5%", left: "80%" } },
{ id: 28, name: "General2", price: 100, selected: false, position: { top: "30.5%", left: "78.8%" } },



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
    <Header />

    <main className="main-content">
    <h1>Selección de Asientos</h1>
    <div className="seat-selection">
        <div className="seat-map-container">
        <img src="/imagenes/seating-circular.jpg" alt="Mapa de asientos" className="seat-map" />
        {seats.filter((seat) => !seat.selected).map((seat) => (
            <Draggable key={seat.id} onStop={() => handleDrop(seat.id)}>
            <div className="seat-location" style={{ top: seat.position.top, left: seat.position.left}}>
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
        <a href="/checkout" className="btn-comprar">
            <FaTicketAlt /> Comprar Boletos
        </a>
        </button>
    </div>
    </main>
    <Footer />
</div>
);
};

export default SeatSelection;
