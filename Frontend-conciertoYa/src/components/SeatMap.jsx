import React, { useState } from "react";
import "./SeatMap.css";

const seatData = [
  { id: "A1", zone: "VIP", price: 300, isOccupied: false },
  { id: "A2", zone: "VIP", price: 300, isOccupied: true },
  { id: "A3", zone: "VIP", price: 300, isOccupied: false },
  { id: "B1", zone: "General", price: 150, isOccupied: false },
  { id: "B2", zone: "General", price: 150, isOccupied: false },
  { id: "B3", zone: "General", price: 150, isOccupied: true },
  { id: "C1", zone: "Economy", price: 100, isOccupied: false },
  { id: "C2", zone: "Economy", price: 100, isOccupied: false },
  { id: "C3", zone: "Economy", price: 100, isOccupied: false },
];

const SeatMap = () => {
  const [selectedSeats, setSelectedSeats] = useState([]);

  const handleSeatClick = (seat) => {
    if (selectedSeats.includes(seat)) {
      setSelectedSeats(selectedSeats.filter((s) => s !== seat));
    } else {
      setSelectedSeats([...selectedSeats, seat]);
    }
  };

  const totalPrice = selectedSeats.reduce((total, seatId) => {
    const seat = seatData.find((s) => s.id === seatId);
    return total + (seat ? seat.price : 0);
  }, 0);

  return (
    <div className="seat-map">
      <h2 className="title">Selecciona tu asiento</h2>

      <div className="seat-container">
        {["VIP", "General", "Economy"].map((zone) => (
          <div key={zone} className="zone">
            <h3 className="zone-title">{zone}</h3>
            <div className="row">
              {seatData
                .filter((seat) => seat.zone === zone)
                .map((seat) => (
                  <div
                    key={seat.id}
                    className={`seat ${seat.isOccupied ? "occupied" : ""} ${
                      selectedSeats.includes(seat.id) ? "selected" : ""
                    }`}
                    onClick={() => !seat.isOccupied && handleSeatClick(seat.id)}
                  >
                    <svg
                      width="50"
                      height="50"
                      viewBox="0 0 64 64"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <rect
                        x="12"
                        y="22"
                        width="40"
                        height="20"
                        rx="5"
                        ry="5"
                        fill={
                          seat.isOccupied
                            ? "gray"
                            : selectedSeats.includes(seat.id)
                            ? "#42a5f5"
                            : "#66bb6a"
                        }
                      />
                      <rect
                        x="18"
                        y="10"
                        width="28"
                        height="15"
                        rx="5"
                        ry="5"
                        fill="white"
                      />
                    </svg>
                    <span className="seat-label">{seat.id}</span>
                  </div>
                ))}
            </div>
          </div>
        ))}
      </div>

      <div className="selection">
        <h3>Tu selección:</h3>
        {selectedSeats.length > 0 ? (
          <ul>
            {selectedSeats.map((seat) => (
              <li key={seat}>
                {seat} - ${seatData.find((s) => s.id === seat)?.price}
              </li>
            ))}
          </ul>
        ) : (
          <p>No has seleccionado asientos</p>
        )}
        <h3>Total: ${totalPrice}</h3>
      </div>
    </div>
  );
};

export default SeatMap;
