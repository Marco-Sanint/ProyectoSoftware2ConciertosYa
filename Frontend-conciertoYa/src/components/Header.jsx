import React from "react";
import { Link } from "react-router-dom";
import { FaUserCircle, FaBell } from "react-icons/fa";
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
      <div className="links">
        <nav className="nav-links">
        <Link to="/" className="nav-link">Inicio</Link>
        <Link to="/eventos/conciertos" className="nav-link conciertos">
          Conciertos
          <span className="badge">5</span>
        </Link>
        <Link to="/eventos/exposiciones" className="nav-link">Exposiciones</Link>
        <Link to="/eventos/teatro" className="nav-link">Teatro</Link>
      </nav>
      </div>
      <div className="user-actions">
        <div className="notification-icon">
          <FaBell size={25} className="icon" />
          <span className="badge">3</span>
        </div>
        <div className="user-icon">
          <FaUserCircle size={30} className="icon" />
        </div>
        <div className="user-tools">
        <select className="language-select">
          <option value="es">ES</option>
          <option value="en">EN</option>
        </select>
        <input type="text" placeholder="Buscar eventos..." className="search-bar" />
      </div>
      </div>
    
    </header>
  );
};

export default Header;
