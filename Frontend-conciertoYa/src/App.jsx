import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
import SeatSelection from "./components/SeatSelection";
import Profile from "./components/Profile";  // Asegúrate de importar el componente de perfil
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  return (
    <Router>
      <Routes>
        {/* Home accesible sin autenticación */}
        <Route 
          path="/" 
          element={<Home />} 
        />

        {/* Ruta de login */}
        <Route 
          path="/login"
          element={<Login setIsAuthenticated={setIsAuthenticated} />}
        />
        
        {/* Ruta a seleccionar asientos, solo accesible si está autenticado */}
        <Route 
          path="/seats" 
          element={isAuthenticated ? <SeatSelection /> : <Navigate to="/login" />}
        />
        
        {/* Ruta al perfil, solo accesible si está autenticado */}
        <Route 
          path="/profile" 
          element={isAuthenticated ? <Profile /> : <Navigate to="/login" />} 
        />
      </Routes>
    </Router>
  );
}

export default App;
