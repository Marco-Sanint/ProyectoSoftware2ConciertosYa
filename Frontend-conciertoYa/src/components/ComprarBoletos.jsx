import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import Header from './Header'; // Asegúrate de tener tu Header
import Footer from './Footer'; // Asegúrate de tener tu Footer
import './ComprarBoletos.css'; // Asegúrate de tener tu archivo CSS

const ComprarBoletos = () => {
  const location = useLocation();
  const navigate = useNavigate(); // Hacemos uso de useNavigate para la redirección
  const evento = location.state;  // Obtener los detalles del evento desde el state

  const [cantidadBoletos, setCantidadBoletos] = useState(1); // Para manejar la cantidad de boletos

  if (!evento) {
    return <p>No se ha seleccionado un evento.</p>;
  }

  // Función que maneja la compra
  const handleCompra = () => {
    // Pasa los detalles del evento y la cantidad de boletos al Checkout
    navigate("/checkout", { state: { evento, cantidadBoletos } });
  };

  return (
    <div className="comprar-boletos-page">
      <Header /> {/* Muestra el header */}
      
      <div className="comprar-boletos-container">
        <div className="evento-info">
          <div className="evento-imagen">
            <img src={evento.imagen} alt={evento.nombre} />
          </div>

          <div className="evento-detalles">
            <h1>{evento.nombre}</h1>
            <p><strong>Descripción:</strong> {evento.descripcion}</p>
            <p><strong>Fecha:</strong> {evento.fecha}</p>
            <p><strong>Ubicación:</strong> {evento.ubicacion}</p>
          </div>
        </div>

        <div className="formulario-compra">
          <h3>Selecciona la cantidad de boletos:</h3>
          <div className="input-container">
            <input 
              type="number" 
              min="1" 
              max="10" 
              placeholder="Cantidad de boletos" 
              className="input-boletos" 
              value={cantidadBoletos}
              onChange={(e) => setCantidadBoletos(e.target.value)}
            />
            <button 
              className="btn-comprar-boletos" 
              onClick={handleCompra} // Redirige al checkout
            >
              Comprar Boletos
            </button>
          </div>
        </div>
      </div>

      <Footer /> {/* Muestra el footer */}
    </div>
  );
};

export default ComprarBoletos;
