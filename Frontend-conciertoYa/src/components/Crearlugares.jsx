import React, { useState } from "react";
import  "./CrearLugares.css";
import Header from "./Header";
import Footer from "./Footer";
const CrearLugar = () => {
  const [lugar, setLugar] = useState({
    nombre: "",
    direccion: "",
    capacidad: "",
    descripcion: "",
    imagen: null,
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setLugar({
      ...lugar,
      [name]: value,
    });
  };

  const handleImageChange = (e) => {
    setLugar({
      ...lugar,
      imagen: e.target.files[0],
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Aquí puedes manejar el envío del formulario
    console.log("Lugar creado:", lugar);
  };

  return (
    <div className="form-container">
        <Header />
      <div className="form-header">
        <h2 className="form-title">¡Haz realidad el próximo escenario! 🎭</h2>
      </div>

      <form className="form-details" onSubmit={handleSubmit}>
        {/* Campo de nombre */}
        <div className="form-field">
          <label htmlFor="nombre">Nombre del Lugar</label>
          <input
            type="text"
            id="nombre"
            name="nombre"
            value={lugar.nombre}
            onChange={handleChange}
            placeholder="Ej: Estadio Nacional"
            required
          />
        </div>

        {/* Campo de dirección */}
        <div className="form-field">
          <label htmlFor="direccion">Dirección</label>
          <input
            type="text"
            id="direccion"
            name="direccion"
            value={lugar.direccion}
            onChange={handleChange}
            placeholder="Ej: Av. Principal 123, Ciudad"
            required
          />
        </div>

        {/* Campo de capacidad */}
        <div className="form-field">
          <label htmlFor="capacidad">Capacidad</label>
          <input
            type="number"
            id="capacidad"
            name="capacidad"
            value={lugar.capacidad}
            onChange={handleChange}
            placeholder="Ej: 5000"
            required
            min="1"
          />
        </div>

        {/* Campo de descripción */}
        <div className="form-field">
          <label htmlFor="descripcion">Descripción</label>
          <textarea
            id="descripcion"
            name="descripcion"
            value={lugar.descripcion}
            onChange={handleChange}
            placeholder="Breve descripción del lugar"
          />
        </div>

        {/* Campo de imagen */}
        <div className="form-field">
          <label htmlFor="imagen">Subir Imagen del Lugar</label>
          <input type="file" id="imagen" onChange={handleImageChange} />
          {lugar.imagen && (
            <img
              src={URL.createObjectURL(lugar.imagen)}
              alt="Vista previa"
              className="selected-image"
            />
          )}
        </div>

        {/* Botón de enviar */}
        <button type="submit" className="form-btn">
          Crear Lugar
        </button>
      </form>
        <Footer />
    </div>
    
  );
};

export default CrearLugar;
