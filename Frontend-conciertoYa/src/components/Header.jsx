import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { FaUserCircle, FaBell } from "react-icons/fa"; // Iconos de usuario y campana
import './Header.css';

const Header = () => {
  const [isHidden, setIsHidden] = useState(false);
  const [lastScrollY, setLastScrollY] = useState(0);

  const handleScroll = () => {
    const currentScrollY = window.scrollY;

    // Detecta el desplazamiento hacia abajo y hacia arriba
    if (currentScrollY > lastScrollY) {
      setIsHidden(true); // Desplazamiento hacia abajo, ocultar el header
    } else {
      setIsHidden(false); // Desplazamiento hacia arriba, mostrar el header
    }

    setLastScrollY(currentScrollY <= 0 ? 0 : currentScrollY); // Evitar valores negativos
  };

  useEffect(() => {
    window.addEventListener("scroll", handleScroll);

    // Limpiar el event listener al desmontar el componente
    return () => {
      window.removeEventListener("scroll", handleScroll);
    };
  }, [lastScrollY]);

  return (
    <header className={`header ${isHidden ? "hidden" : ""}`}>
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
