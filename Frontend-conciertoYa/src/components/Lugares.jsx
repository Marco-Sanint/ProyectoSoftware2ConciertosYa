import React from 'react';
import './Lugares.css'; // Asegúrate de que este archivo esté correctamente importado.
import { FaMapMarkerAlt } from 'react-icons/fa';

const Lugares = () => {
  return (
    <div className="section lugares">
      <h2>Lugares Destacados</h2>
      <div className="grid">
        <div className="card-lugar">
          <img src="/imagenes/lugar1.webp" alt="Lugar 1" />
          <h3>Movistar Arena </h3>
          <p>El principal centro de eventos de Colombia Un lugar ideal para conciertos y eventos masivos.</p>
          <div>
            <a href="https://maps.app.goo.gl/wtruequmoj1BnNWy5" className="social-link" target="_blank" rel="noopener noreferrer">
              <FaMapMarkerAlt />
              Ver en Google Maps
            </a>
          </div>
        </div>

        <div className="card-lugar">
          <img src="/imagenes/lugar2.webp" alt="Lugar 2" />
          <h3>Teatro Mayor Julio Mario Santo Domingo</h3>
          <p>El Centro Cultural Julio Mario Santo Domingo Un hermoso lugar con una arquitectura impresionante y una vista increíble.</p>
          <div>
            <a href="https://maps.app.goo.gl/hKyVzauxir6wg5za9" target="_blank" rel="noopener noreferrer">
              <FaMapMarkerAlt />
              Ver en Google Maps
            </a>
          </div>
        </div>

        {/* Agrega más lugares según sea necesario */}
      </div>
    </div>
  );
};

export default Lugares;
