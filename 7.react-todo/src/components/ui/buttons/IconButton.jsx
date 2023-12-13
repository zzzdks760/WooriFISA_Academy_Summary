import React from 'react'

const IconButton = ({ textColor, icon, onClick }) => {
    return (
        <button onClick={onClick}
            className={`w-8 text-xl font-semibold cursor-pointer ${textColor}`}>
            {icon}
        </button>
    )
}

export default IconButton