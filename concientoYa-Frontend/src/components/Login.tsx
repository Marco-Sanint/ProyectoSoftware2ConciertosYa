import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './LoginSign.css';
const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await fetch('http://localhost:5000/auth/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
      });

      const data = await response.json();
      if (response.ok) {
        alert('Login exitoso');
        localStorage.setItem('token', data.token); // Guardar token en localStorage
        navigate('/dashboard'); // Redirigir al dashboard o página protegida
      } else {
        alert(data.error || 'Error en el login');
      }
    } catch (error) {
      alert('Error al conectar con el servidor');
    }
  };

  return (
    <div className="form-container">
      <h2>Login</h2>
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Email"
        required
      />
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        placeholder="Password"
        required
      />
      <button onClick={handleLogin}>Iniciar sesión</button>
      <p>
        ¿No tienes cuenta? <a href="/signup">Regístrate aquí</a>
      </p>
    </div>
  );
};

export default Login;
