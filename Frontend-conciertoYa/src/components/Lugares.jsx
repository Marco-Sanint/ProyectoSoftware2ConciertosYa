import React from 'react';
import './Lugares.css'; // Asegúrate de que este archivo esté correctamente importado.
import { FaMapMarkerAlt } from 'react-icons/fa';

const Lugares = () => {
  return (
    <div className="section lugares">
      <h2>Lugares Destacados</h2>
      <div className="grid">
        <div className="card-lugar">
          <img src="ruta/a/imagen/lugar1.jpg" alt="Lugar 1" />
          <h3>Lugar 1</h3>
          <p>Descripción breve del lugar 1. Un lugar ideal para conciertos y eventos masivos.</p>
          <div>
            <a href="https://google.com/maps?q=lugar1" className="social-link" target="_blank" rel="noopener noreferrer">
              <FaMapMarkerAlt />
              Ver en Google Maps
            </a>
          </div>
        </div>

        <div className="card-lugar">
          <img src="ruta/a/imagen/lugar2.jpg" alt="Lugar 2" />
          <h3>Lugar 2</h3>
          <p>Un hermoso lugar con una arquitectura impresionante y una vista increíble.</p>
          <div>
            <a href="https://google.com/maps?q=lugar2" className="social-link" target="_blank" rel="noopener noreferrer">
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
