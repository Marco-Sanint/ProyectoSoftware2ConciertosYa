import React, { useState } from 'react';
import './Login.css';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!email || !password) {
      setError('Por favor ingrese ambos campos');
      return;
    }

    try {
      const response = await fetch('http://localhost:8080/api/clientes/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          email, // Usar `email` según el DTO esperado en el backend
          password,
        }),
      });

      const result = await response.json();

      if (response.ok) {
        // Éxito en la autenticación
        console.log('Autenticación exitosa:', result.message);
        localStorage.setItem('isAuthenticated', 'true'); // Guardar estado de autenticación
        navigate('/'); // Redirigir al home
      } else {
        // Error de autenticación
        setError(result.message || 'Credenciales incorrectas');
      }
    } catch (err) {
      console.error('Error al conectar con la API:', err);
      setError('No se pudo conectar con el servidor');
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
              onChange={(e) => setEmail(e.target.value)} // Actualizar el estado correctamente
              required
            />
          </div>
          <div className="input-group">
            <input
              type="password"
              className="input-text"
              placeholder="Contraseña"
              value={password}
              onChange={(e) => setPassword(e.target.value)} // Actualizar el estado correctamente
              required
            />
          </div>
          <button type="submit" className="login-btn">CONTINUAR</button>
        </form>

        {error && <p className="error-text">{error}</p>}

        <div className="forgot-password">
          <a href="#">¿OLVIDASTE LA CONTRASEÑA?</a>
        </div>

        <div className="other-options">
          <p>¿No tienes cuenta? <a href="/register">Regístrate</a></p>
        </div>
      </div>
    </div>
  );
};

export default Login;
