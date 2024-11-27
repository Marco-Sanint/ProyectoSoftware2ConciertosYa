import React from "react";
import { Link } from "react-router-dom";
import { FaUserCircle, FaBell } from "react-icons/fa"; // Iconos de usuario y campana
import './Header.css';

const Header = () => {
  return (
    <header className="header">
      <div className="logo-container">
        <img 
          src="/imagenes/LogoConciertoYA.png" 
          alt="Logo de ConciertoYa" 
          className="logo" 
        />
      </div>
      <nav className="nav-links">
        <Link to="/" className="nav-link">Inicio</Link>
        <Link to="/eventos/conciertos" className="nav-link conciertos">
          Conciertos
          <span className="badge">5</span> {/* Indicador de disponibilidad */}
        </Link>
        <Link to="/eventos/exposiciones" className="nav-link">Exposiciones</Link>
        <Link to="/eventos/teatro" className="nav-link">Teatro</Link>
      </nav>
      <div className="user-actions">
        <div className="notification-icon">
          <FaBell size={25} />
          <span className="badge"></span> {/* Número de notificaciones */}
        </div>
        <div className="user-icon">
          {/* Envolvemos el icono de usuario en un Link */}
          <Link to="/profile">
            <FaUserCircle size={30} color="#f0f0f0" />
          </Link>
        </div>
        <select className="language-select">
          <option value="es">ES</option>
          <option value="en">EN</option>
        </select>
      </div>
      <input type="text" placeholder="Buscar eventos..." className="search-bar" />
    </header>
  );
};

export default Header;
