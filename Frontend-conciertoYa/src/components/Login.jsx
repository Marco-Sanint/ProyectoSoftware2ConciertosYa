import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css"; // El CSS actualizado

function Login({ setIsAuthenticated }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    if (email === "user@example.com" && password === "password") {
      setIsAuthenticated(true);
      navigate("/");
    } else {
      alert("Credenciales incorrectas");
    }
  };

  return (
    <div className="login-container">
      <div className="login-slider">
        <div className="slider">
          <div className="slide active">
            <img
              src="/imagenes/login1.jpg"
              alt="Fondo decorativo"
              className="slider-image"
            />
            <div className="slider-content">
              <p className="slider-text">
                Bienvenido a ConciertoYa.Ingresa tus credenciales para
                continuar.
              </p>
            </div>
          </div>
        </div>
      </div>

      <div className="login-text-container">
        <div className="login-form-container">
          <h2 className="login-title">Iniciar sesión</h2>
          <form className="login-form active" onSubmit={handleSubmit}>
            <div className="input-group">
              <input
                type="email"
                className="input-text"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            <div className="input-group">
              <input
                type="password"
                className="input-text"
                placeholder="Contraseña"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            <button type="submit" className="login-btn">
              Iniciar sesión
            </button>
            <p className="link">
              <a href="#forgot-password">¿Olvidaste tu contraseña?</a>
            </p>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;
