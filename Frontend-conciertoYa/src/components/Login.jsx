import React, { useState } from 'react';
import './Login.css';
import { useNavigate } from 'react-router-dom'; // Importar useNavigate

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isChecked, setIsChecked] = useState(false);
  const navigate = useNavigate(); // hook para navegación

  const handleSubmit = (e) => {
    e.preventDefault();
    // Validación de credenciales fijas
    if (email === 'user@example.com' && password === 'password') {
      // Guardar el estado de autenticación en el localStorage
      localStorage.setItem('isAuthenticated', 'true');
      // Redirigir al componente Home ("/")
      navigate("/");  // Redirección a la página principal
    } else {
      alert('Credenciales incorrectas');
    }
  };

  return (
    <div className="login-container">
      <div className="login-form">
        <h1 className="welcome-text">¡HOLA! BIENVENIDO A CONCIERTOYA</h1>
        <p className="description">Inicia sesión para comprar entradas o descargarlas desde tu cuenta personal</p>

        <form onSubmit={handleSubmit}>
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
          <div className="checkbox-container">
            <input
              type="checkbox"
              id="keep-logged"
              checked={isChecked}
              onChange={() => setIsChecked(!isChecked)}
            />
            <label htmlFor="keep-logged">Sigue conectado</label>
          </div>
          <button type="submit" className="login-btn">CONTINUAR</button>
        </form>

        <div className="forgot-password">
          <a href="#">¿OLVIDASTE LA CONTRASEÑA?</a>
        </div>

        <div className="other-options">
          <p>¿No tienes cuenta? <a href="/register">Regístrate</a></p>
        </div>
      </div>
    </div>
  );
}

export default Login;
