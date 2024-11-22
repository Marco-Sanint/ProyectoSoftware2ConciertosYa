import React, { useState } from "react";
import Draggable from "react-draggable";
import "./SeatSelection.css";
import Footer from "./Footer";
import Header from "./Header";


const SeatSelection = () => {
const [seats, setSeats] = useState([
{ id: 1, name: "VIP 1", price: 200, selected : false, position: { top: "27%", left: "25%" } },
{ id: 2, name: "VIP 2", price: 200, selected : false, position: { top: "27%", left: "45.8%" } },
{ id: 3, name: "VIP 3", price: 200, selected : false, position: { top: "27%", left: "67.5%" } },
{ id: 4, name: "Platino ", price: 150, selected : false,position: { top: "44%", left: "24.8%" } },
{ id: 5, name: "Platino ", price: 150, selected : false,position: { top: "45%", left: "45%" } },
{ id: 6, name: "Platino ", price: 150, selected : false,position: { top: "44%", left: "66.2%" } },
{ id: 7, name: "General 1", price: 150,selected : false , position: { top: "15%", left: "12.5%" } },
{ id: 8, name: "General 1", price: 150,selected : false , position: { top: "30%", left: "10%" } },
{ id: 9, name: "General 1", price: 150,selected : false , position: { top: "45%", left: "12.4%" } },
{ id: 10, name: "General 1", price: 150,selected : false , position: { top: "59.5%", left: "19.5%" } },
{ id: 11, name: "General 1", price: 150,selected : false , position: { top: "71%", left: "32%" } },
{ id: 12, name: "General 1", price: 150,selected : false , position: { top: "74%", left: "47.8%" } },
{ id: 13, name: "General 1", price: 150,selected : false , position: { top: "69%", left: "62.5%" } },
{ id: 14, name: "General 1", price: 150,selected : false , position: { top: "57%", left: "73%" } },
{ id: 15, name: "General 1", price: 150,selected : false , position: { top: "41.3%", left: "79%" } },
{ id: 16, name: "General 1", price: 150,selected : false , position: { top: "26%", left: "79.7%" } },
{ id: 17, name: "General 1", price: 150,selected : false , position: { top: "11%", left: "76.5%" } },

{ id: 18, name: "General 2", price: 100, selected : false, position: { top: "17%", left: "1%" } },
{ id: 19, name: "General 2", price: 100, selected : false, position: { top: "32%", left: "-0.1%" } },
{ id: 20, name: "General 2", price: 100, selected : false, position: { top: "50%", left: "1.8%" } },
{ id: 21, name: "General 2", price: 100, selected : false, position: { top: "70%", left: "12%" } },
{ id: 22, name: "General 2", price: 100, selected : false, position: { top: "83.2%", left: "28.5%" } },
{ id: 23, name: "General 2", price: 100, selected : false, position: { top: "86.9%", left: "49%" } },
{ id: 24, name: "General 2", price: 100, selected : false, position: { top: "80%", left: "68%" } },
{ id: 25, name: "General 2", price: 100, selected : false, position: { top: "63%", left: "83%" } },
{ id: 26, name: "General 2", price: 100, selected : false, position: { top: "45%", left: "89%" } },
{ id: 27, name: "General 2", price: 100, selected : false, position: { top: "30%", left: "90%" } },
{ id: 28, name: "General 2", price: 100, selected : false, position: { top: "15%", left: "88.5%" } },

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
<>
    <div className="page-container">
        <div className="header">
        <Header />
        </div>

    <main className="main-content">
        <h1>Selección de Asientos</h1>
        <div className="event-info">
        <h2>Concierto de Banda XYZ</h2>
        <p>Fecha: 25 de Noviembre, 2024</p>
        <p>Lugar: Gran Arena Ciudad</p>
        </div>

        <div className="seat-selection">
        <div className="seat-container">
            <img
            src="/imagenes/DistribucionEscenario.png"
            alt="Mapa de asientos"
            className="seat-map"
            />
            {seats.filter((seat) => !seat.selected).map((seat) => (
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
    </div>

    <Footer />
</>
);
};

export default SeatSelection;