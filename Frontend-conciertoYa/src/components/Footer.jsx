import React from 'react';
import './Footer.css';
import { FaFacebookF, FaTwitter, FaInstagram, FaLinkedin } from 'react-icons/fa';

const Footer = () => {
  return (
    <footer className="footer">
      <p>&copy; {new Date().getFullYear()} ConciertoYa. Todos los derechos reservados.</p>

      <div className="social-links" aria-label="Redes sociales">
        <a href="https://facebook.com" target="_blank" rel="noopener noreferrer" title="Facebook">
          <FaFacebookF />
        </a>
        <a href="https://twitter.com" target="_blank" rel="noopener noreferrer" title="Twitter">
          <FaTwitter />
        </a>
        <a href="https://instagram.com" target="_blank" rel="noopener noreferrer" title="Instagram">
          <FaInstagram />
        </a>
        <a href="https://linkedin.com" target="_blank" rel="noopener noreferrer" title="LinkedIn">
          <FaLinkedin />
        </a>
      </div>

      <div className="footer-links" aria-label="Enlaces del sitio">
        <a href="/about">Acerca de</a>
        <a href="/contact">Contacto</a>
        <a href="/privacy">Política de privacidad</a>
        <a href="/terms">Términos de servicio</a>
      </div>
    </footer>
  );
};

export default Footer;
