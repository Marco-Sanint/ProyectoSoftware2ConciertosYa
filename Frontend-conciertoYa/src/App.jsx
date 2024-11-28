// src/App.js
import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
import SeatSelection from "./components/SeatSelection";
import Checkout from "./components/Checkout/Checkout";
import SeatMap from "./components/SeatMap";

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  console.log(isAuthenticated); // Verifica si el estado cambia después del login
  return (
    <Router>
      <Routes>
        <Route 
          path="/" 
          element={isAuthenticated ? <Home /> : <Navigate to="/login" />} 
        />
        <Route 
          path="/login"
          element={<Login setIsAuthenticated={setIsAuthenticated} />}
        />
        <Route path="Seats" element={<SeatSelection />} 
        />
        <Route path="SeatMap" element={<SeatMap/>} 
        />
        <Route path="checkout" element={<Checkout />} 
        />
      </Routes>
    </Router>
  );
}

export default App;