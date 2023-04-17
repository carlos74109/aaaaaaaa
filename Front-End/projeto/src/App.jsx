import { useEffect, useState } from 'react'
import Formulario from './pages/Formulario'
import Usuario from './pages/Usuario';
import 'bootstrap/dist/css/bootstrap.min.css';
import Repositorio from './pages/Repositorio'
import './index.css'
export default function App(){
  
  
  //Use state
  const [dados, setDados] = useState('');

  const [minhaVariavel, setMinhaVariavel] = useState('');
  
  const childToParent = (dados) => {
    setMinhaVariavel(dados)
  }
  
  //UseEffect 

  function pesquisarUsuario(){
   
      fetch(`http://localhost:8080/user/${minhaVariavel}`, {
        headers: {
          Authorization: 'Bearer <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>'
        }
      })
      .then(retorno => retorno.json())
      .then(retorno_dados => setDados(retorno_dados))
      alert("Requisição realizada com sucesso, desça a página para visualizar a consulta")
  }

  let [dadosRepositorio, setDadosRepositorio] = useState('');
 
 
  const linkGitParaConsulta = (dados) => {
    setDadosRepositorio(dados)
  }
    
  const pesquisarRepositorio = () =>{
      fetch(`http://localhost:8080/user/${dadosRepositorio.vetor.login}/repos`, {
        headers: {
          Authorization: 'Bearer <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>'
        }
      })
        .then(retorno => retorno.json())
        .then(retorno_dadosRepositorio => setDadosRepositorio(retorno_dadosRepositorio)), []
  }

  return(
    <div>
      <Formulario paiLogin={childToParent} pesquisarUsuario={pesquisarUsuario} />
      <br></br>
        <Usuario vetor={dados} consultaRepo={linkGitParaConsulta} pesquisarRepositorio={pesquisarRepositorio}/>     
      <Repositorio dadosRepositorio={dadosRepositorio}/>
      
    </div>   
  )
}