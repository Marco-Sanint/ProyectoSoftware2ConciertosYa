import React, { useState } from "react";
import Draggable from "react-draggable";
import "./SeatSelection.css";

const SeatSelection = () => {
  const [seats, setSeats] = useState([
    { id: 1, name: "A1", price: 200, selected: false, position: { top: "30%", left: "35%" } },
    { id: 2, name: "A2", price: 200, selected: false, position: { top: "30%", left: "50%" } },
    { id: 3, name: "A3", price: 200, selected: false, position: { top: "30%", left: "65%" } },
    { id: 4, name: "B1", price: 150, selected: false, position: { top: "45%", left: "35%" } },
    { id: 5, name: "B2", price: 150, selected: false, position: { top: "45%", left: "50%" } },
    { id: 6, name: "B3", price: 150, selected: false, position: { top: "45%", left: "65%" } },
    // Agrega más asientos según sea necesario
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
      <img src="/images/seating-circular.jpg" alt="Mapa de asientos" className="seat-map" />

      {/* Asientos */}
      {seats
        .filter((seat) => !seat.selected)
        .map((seat) => (
          <Draggable key={seat.id} onStop={() => handleDrop(seat.id)}>
            <div
              className="seat-location"
              style={{
                top: seat.position.top,
                left: seat.position.left,
                position: "absolute",
              }}
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
