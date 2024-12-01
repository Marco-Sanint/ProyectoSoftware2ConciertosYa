import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Register.css"; // Importamos el archivo CSS

function Register() {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState(""); // Para confirmar contraseña
  const [showPassword, setShowPassword] = useState(false); // Controla la visibilidad de la contraseña
  const [showConfirmPassword, setShowConfirmPassword] = useState(false); // Controla la visibilidad de la confirmación
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
      setError("Las contraseñas no coinciden");
      return;
    }

    // Lógica para registrar un usuario (API, almacenamiento, etc.)
    alert("Registro exitoso");
    navigate("/login");
  };

  return (
    <div className="register-container">
      <form onSubmit={handleSubmit} className="register-form">
        <h2 className="welcome-text">Crear una cuenta</h2>

        <div className="input-group">
          <label htmlFor="id">ID</label>
          <input
            id="id"
            type="text"
            className="input-text"
            placeholder="ID"
            value={id}
            onChange={(e) => setId(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="name">Nombre</label>
          <input
            id="name"
            type="text"
            className="input-text"
            placeholder="Nombre completo"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="email">Correo electrónico</label>
          <input
            id="email"
            type="email"
            className="input-text"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <div className="input-group">
          <label htmlFor="phone">Teléfono</label>
          <input
            id="phone"
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
            id="address"
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
            id="password"
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
            id="confirmPassword"
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
          <p>¿Ya tienes una cuenta? <a href="/login">Inicia sesión</a></p>
        </div>
      </form>
    </div>
  );
}

export default Register;
