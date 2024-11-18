import React, { useState } from "react";
import Draggable from "react-draggable";
import "./SeatSelection.css"; // Archivo CSS de esta página

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

  return (
    <div className="seat-map-container">
      <h1>Selección de Asientos</h1>
      
      <img public="/imagenes/seating-circular.jpg" alt="Mapa de asientos" className="seat-map" />

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
      </div>
    </div>
  );
};

export default SeatSelection;
