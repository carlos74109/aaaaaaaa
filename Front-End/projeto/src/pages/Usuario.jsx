import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';
import Col from 'react-bootstrap/Col';
import '../../public/Ususario.css'

export default function Usuario({vetor, consultaRepo, pesquisarRepositorio}){

    const handleInputChange = (event) => {
      event.preventDefault();
      pesquisarRepositorio()
      
    };
   

    return (
    <div className='divUsuario'>
       
       <div className='teste1'>
        <Card  className="h-100 d-flex align-items-center justify-content-center">
            <Card style={{ width: '25rem' }}>
            <Col xs={15} md={12}>
            
                <Card.Img variant="top" className='cardBody' src={vetor.avatar_url} roundedCircle/>

            </Col>     
            <Card.Body >
            <Card.Title style={{color: 'white'}}>{vetor.name}</Card.Title>
                <Card.Text>{vetor.bio}</Card.Text>
            </Card.Body>
            <ListGroup className="list-group-flush">
                <ListGroup.Item>login: {vetor.login}</ListGroup.Item>
                <ListGroup.Item>Localidade: {vetor.location}</ListGroup.Item>
                <ListGroup.Item>Quantidade de repositorios: {
                     vetor.public_repos > 0 ? vetor.public_repos : <p>Usuario não possui Repositorio</p>
                    }</ListGroup.Item>
                <ListGroup.Item>Seguindo: {vetor.followers}</ListGroup.Item>
                <ListGroup.Item>Seguidores: {vetor.following}</ListGroup.Item>
            </ListGroup>
            <Card.Body className='cardBody'>
                <form onSubmit={handleInputChange} >
                    <button onClick={() => consultaRepo({vetor})}>Repositório</button>
                </form>
            </Card.Body>  
            </Card>
        </Card>
        </div>
        </div>
    )
}