import { BsSearch } from 'react-icons/bs';
import { useEffect, useState } from 'react'
import '../../public/style.css'

export default function Formulario({paiLogin, pesquisarUsuario}){

  const [login, setsetLogin] = useState("");

  const handleInputChange = (event) => {
    event.preventDefault();
    pesquisarUsuario()
   
  };
 
    
    return(
        <div>
          <section>
            <div className='form-box'>
              <div className='form-value'>
                <form onSubmit={handleInputChange} action="">
                  <h2>GitCar</h2>
                <div className='inputBox'>
                  <input className='inputLogin' type="text"  
                     onChange={(e)=> setsetLogin(e.target.value)}
                  />
                  <label htmlFor="">Login do Git:</label>
                </div> 
                                      
           <button variant="secondary"  type='submit' onClick={() => paiLogin(login)}><BsSearch/>Pesquisar</button>      
        </form>
        </div>
      </div>
      </section>  
    </div>
    )
}