// src/components/ProtectedRoute.jsx
import React from "react";
import { Navigate } from "react-router-dom";

function ProtectedRoute({ isAuthenticated, children }) {
  if (!isAuthenticated) {
    // Si no está autenticado, redirige al login
    return <Navigate to="/login" />;
  }

  return children;
}

export default ProtectedRoute;
