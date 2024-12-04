import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Register.css";

function Register() {
  const [cedula, setCedula] = useState("");
  const [name, setName] = useState("");
  const [mail, setMail] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState(""); 
  const [showPassword, setShowPassword] = useState(false); 
  const [showConfirmPassword, setShowConfirmPassword] = useState(false); 
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Validar el correo electrónico
    if (!/\S+@\S+\.\S+/.test(mail)) {
      setError("Por favor, ingresa un correo electrónico válido.");
      return;
    }

    // Validar las contraseñas
    if (password !== confirmPassword) {
      setError("Las contraseñas no coinciden");
      return;
    }

    // Crear el objeto cliente para enviar a la API
    const cliente = {
      cedula,
      nombre: name,
      mail, // Cambié "correo" por "mail" para coincidir con el backend
      telefono: phone,
      direccion: address,
      password, 
    };

    try {
      const response = await fetch("http://localhost:8080/api/clientes", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(cliente),
      });

      if (response.ok) {
        const data = await response.json();
        alert("Registro exitoso");
        console.log("Cliente registrado:", data);
        navigate("/login"); // Redirigir al login
      } else {
        const errorData = await response.json();
        setError(errorData.message || "Error al registrar el cliente");
      }
    } catch (err) {
      console.error("Error al conectar con la API:", err);
      setError("No se pudo conectar con el servidor");
    }
  };

  return (
    <div className="register-container">
      <form onSubmit={handleSubmit} className="register-form">
        <h2 className="welcome-text">Crear una cuenta</h2>

        <div className="input-group">
          <label htmlFor="cedula">Cédula</label>
          <input
            name="cedula"
            type="text"
            className="input-text"
            placeholder="Cédula"
            value={cedula}
            onChange={(e) => setCedula(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="name">Nombre</label>
          <input
            name="name"
            type="text"
            className="input-text"
            placeholder="Nombre completo"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="mail">Correo electrónico</label>
          <input
            name="mail"
            type="email"
            className="input-text"
            placeholder="Correo electrónico"
            value={mail}
            onChange={(e) => setMail(e.target.value.trim())} // Asegurarse de no tener espacios al principio o al final
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="phone">Teléfono</label>
          <input
            name="phone"
            type="tel"
            className="input-text"
            placeholder="Teléfono"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="address">Dirección</label>
          <input
            name="address"
            type="text"
            className="input-text"
            placeholder="Dirección"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            required
          />
        </div>

        {/* Contraseña */}
        <div className="input-group password-group">
          <label htmlFor="password">Contraseña</label>
          <input
            name="password"
            type={showPassword ? "text" : "password"}
            className="input-text"
            placeholder="Contraseña"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <span
            className="toggle-password"
            onClick={() => setShowPassword(!showPassword)}
          >
            {showPassword ? "🙈" : "👁️"}
          </span>
        </div>

        {/* Confirmar Contraseña */}
        <div className="input-group password-group">
          <label htmlFor="confirmPassword">Confirmar contraseña</label>
          <input
            name="confirmPassword"
            type={showConfirmPassword ? "text" : "password"}
            className="input-text"
            placeholder="Confirmar contraseña"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
          />
          <span
            className="toggle-password"
            onClick={() => setShowConfirmPassword(!showConfirmPassword)}
          >
            {showConfirmPassword ? "🙈" : "👁️"}
          </span>
        </div>

        {error && <p className="error-text">{error}</p>}

        <button type="submit" className="register-btn">
          Registrarse
        </button>

        <div className="other-options">
          <p>
            ¿Ya tienes una cuenta? <a href="/login">Inicia sesión</a>
          </p>
        </div>
      </form>
    </div>
  );
}

export default Register;
