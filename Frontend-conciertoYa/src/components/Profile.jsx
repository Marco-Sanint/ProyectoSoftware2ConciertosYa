// Profile.js
import React from "react";
import './Profile.css';
import Header from './Header'; // Importamos el Header

const Profile = () => {
  return (
    <div className="profile-container">
      <Header /> {/* Usamos el Header aquí */}

      <div className="profile-header">
        <h2 className="profile-title">Mi Perfil</h2>
      </div>

      <div className="profile-details">
        <div className="profile-info">
          <h3>Información del Usuario</h3>
          <p><strong>Nombre:</strong> Jhonatan Tamayo</p>
          <p><strong>Email:</strong> jhonatan@conciertoya.com</p>
          <p><strong>Teléfono:</strong> 123-456-7890</p>
          <p><strong>Ciudad:</strong> Manizales, Colombia</p>
        </div>

        <div className="profile-actions">
          <button className="profile-btn">Editar Perfil</button>
          <button className="profile-btn logout-btn">Cerrar Sesión</button>
        </div>
      </div>
    </div>
  );
}

export default Profile;
