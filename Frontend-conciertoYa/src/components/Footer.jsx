// Footer.jsx
import React from 'react';
import './Footer.css';
import { FaFacebookF, FaTwitter, FaInstagram, FaLinkedin } from 'react-icons/fa'; // Importa iconos sociales

const Footer = () => {
  return (
    <footer className="footer">
      <p>&copy; 2024 ConciertoYa. Todos los derechos reservados.</p>

      <div className="social-links">
        <a href="https://facebook.com" target="_blank" rel="noopener noreferrer">
          <FaFacebookF />
        </a>
        <a href="https://twitter.com" target="_blank" rel="noopener noreferrer">
          <FaTwitter />
        </a>
        <a href="https://instagram.com" target="_blank" rel="noopener noreferrer">
          <FaInstagram />
        </a>
        <a href="https://linkedin.com" target="_blank" rel="noopener noreferrer">
          <FaLinkedin />
        </a>
      </div>

      <div className="footer-links">
        <a href="/about">Acerca de</a>
        <a href="/contact">Contacto</a>
        <a href="/privacy">Política de privacidad</a>
        <a href="/terms">Términos de servicio</a>
      </div>
    </footer>
  );
};

export default Footer;
