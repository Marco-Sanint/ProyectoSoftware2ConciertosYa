// Profile.js
import React, { useState, useEffect } from "react";
import './Profile.css';
import Header from './Header'; // Importamos el Header
import axios from 'axios'; // O cualquier cliente HTTP que estés utilizando

const Profile = () => {
  // Estado para la información del usuario
  const [userData, setUserData] = useState({
    name: '',
    email: '',
    phone: '',
    city: '',
  });

  // Estado para manejar si está en modo edición
  const [isEditing, setIsEditing] = useState(false);

  // Estado para manejar errores al guardar los cambios
  const [error, setError] = useState('');

  // Llamada a la API para obtener la información del usuario
  useEffect(() => {
    // Aquí iría tu API o lógica para cargar los datos del usuario
    axios.get('/api/user/profile')
      .then(response => {
        setUserData(response.data); 
      })
      .catch(err => {
        setError('Error al cargar los datos');
      });
  }, []);

  // Manejar cambios en los campos de entrada
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUserData({
      ...userData,
      [name]: value,
    });
  };

  // Guardar los cambios de perfil
  const handleSaveChanges = () => {
    axios.put('/api/user/profile', userData)
      .then(response => {
        setIsEditing(false); // Desactivar el modo edición
        alert('Perfil actualizado correctamente');
      })
      .catch(err => {
        setError('Error al actualizar los datos');
      });
  };

  return (
    <div className="profile-container">
      <Header /> {/* Usamos el Header aquí */}

      <div className="profile-header">
        <h2 className="profile-title">Mi Perfil</h2>
      </div>

      <div className="profile-details">
        <div className="profile-info">
          <h3>Información del Usuario</h3>
          <div className="profile-item">
            <strong>Nombre:</strong>
            {isEditing ? (
              <input
                type="text"
                name="name"
                value={userData.name}
                onChange={handleInputChange}
              />
            ) : (
              <p>{userData.name}</p>
            )}
          </div>

          <div className="profile-item">
            <strong>Email:</strong>
            {isEditing ? (
              <input
                type="email"
                name="email"
                value={userData.email}
                onChange={handleInputChange}
              />
            ) : (
              <p>{userData.email}</p>
            )}
          </div>

          <div className="profile-item">
            <strong>Teléfono:</strong>
            {isEditing ? (
              <input
                type="tel"
                name="phone"
                value={userData.phone}
                onChange={handleInputChange}
              />
            ) : (
              <p>{userData.phone}</p>
            )}
          </div>

          <div className="profile-item">
            <strong>Ciudad:</strong>
            {isEditing ? (
              <input
                type="text"
                name="city"
                value={userData.city}
                onChange={handleInputChange}
              />
            ) : (
              <p>{userData.city}</p>
            )}
          </div>
        </div>

        <div className="profile-actions">
          {isEditing ? (
            <button onClick={handleSaveChanges} className="profile-btn save-btn">
              Guardar Cambios
            </button>
          ) : (
            <button onClick={() => setIsEditing(true)} className="profile-btn edit-btn">
              Editar Perfil
            </button>
          )}
          
          <button className="profile-btn logout-btn">Cerrar Sesión</button>
        </div>
      </div>

      {error && <p className="error-text">{error}</p>}
    </div>
  );
}

export default Profile;
