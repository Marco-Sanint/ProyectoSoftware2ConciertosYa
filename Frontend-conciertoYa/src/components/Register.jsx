import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Register.css"; 
import { Mail } from "@mui/icons-material";

function Register() {
  const [cedula, setcedula] = useState("");
  const [name, setName] = useState("");
  const [Mail, setMail] = useState("");
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

    if (password !== confirmPassword) {
      setError("Las contraseñas no coinciden");
      return;
    }

    // Crear el objeto cliente para enviar a la API
    const cliente = {
      cedula, // cedula
      nombre: name,
      correo: Mail,
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
        navigate("/login");
      } else {
        const errorData = await response.json();
        setError(errorData.message || "Error al registrar el cliente");
      }
    } catch (err) {
      console.error("Error al conectar con la API:", err);
      setError("No se pudo conectar con el servcedulaor");
    }
  };

  return (
    <div className="register-container">
      <form onSubmit={handleSubmit} className="register-form">
        <h2 className="welcome-text">Crear una cuenta</h2>

        <div className="input-group">
          <label htmlFor="cedula">cedula</label>
          <input
            cedula="cedula"
            type="text"
            className="input-text"
            placeholder="cedula"
            value={cedula}
            onChange={(e) => setcedula(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="name">Nombre</label>
          <input
            cedula="name"
            type="text"
            className="input-text"
            placeholder="Nombre completo"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="Mail">Correo electrónico</label>
          <input
            cedula="Mail"
            type="Mail"
            className="input-text"
            placeholder="Mail"
            value={Mail}
            onChange={(e) => setMail(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="phone">Teléfono</label>
          <input
            cedula="phone"
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
            cedula="address"
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
            cedula="password"
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
            cedula="confirmPassword"
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
