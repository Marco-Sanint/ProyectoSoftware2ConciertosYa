import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
import SeatSelection from "./components/SeatSelection";
import Profile from "./components/Profile";  
import Register from "./components/Register";
import CrearEvento from "./components/CrearEvento";
import CrearArtista from "./components/CrearArtista";
import ComprarBoletos from "./components/ComprarBoletos";
import Checkout from "./components/Checkout/Checkout";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  return (
    <Router>
      <Routes>
        {/* Ruta de inicio (Home) */}
        <Route path="/" element={<Home />} />

        {/* Ruta de inicio de sesión (Login) */}
        <Route path="/login" element={<Login />} />

        {/* Ruta de registro (Register) */}
        <Route path="/register" element={<Register />} />
        {/* Ruta de perfil (Profile) */}
        <Route path="/profile" element={<Profile />} />

        {/* Ruta de selección de asientos (SeatSelection) */}
        <Route path="/Seat" element={<SeatSelection />} />

        {/* Rutas para crear evento y artista */}
        <Route path="/nuevoevento" element={<CrearEvento />} />
        <Route path="/nuevoartista" element={<CrearArtista />} />
        
        {/* Ruta de compra de boletos */}
        <Route path="/comprar-boletos" element={<ComprarBoletos />} />
        <Route path="/" element={<ComprarBoletos />} />
        <Route path="/checkout" element={<Checkout />} />
      </Routes>
    </Router>
  );
}

export default App;
