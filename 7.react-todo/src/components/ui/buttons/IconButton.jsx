import React from 'react'

const IconButton = ({ textColor, icon, onClick }) => {

    return (
        <button 
            className={`w-8 text-xl font-semibold cursor-pointer ${textColor}`} onClick={onClick}>
            {icon}
        </button>
    )
}

export default IconButton