import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
import SeatSelection from "./components/SeatSelection";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";


function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

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
        <Route 
          path="/seats" 
          element={isAuthenticated ? <SeatSelection /> : <Navigate to="/login" />}
        />
      </Routes>
    </Router>
  );
}

export default App;
