import Card from 'react-bootstrap/Card';

export default function Usuario({dadosRepositorio}){

  let listaRepositorios = null;

  if(Array.isArray(dadosRepositorio.content)){
    listaRepositorios = dadosRepositorio.content.map((obj) => {
      return (
        <div style={{ marginTop: '1rem' }} className="h-100 d-flex align-items-center justify-content-center">
         <br /> 
        <Card style={{ width: '40rem' }}>
          <Card.Body>
            <Card.Title>{obj.name}</Card.Title>
            <Card.Subtitle className="mb-2 text-muted">{obj.language}</Card.Subtitle>
            <Card.Text>{obj.description}</Card.Text>
             <Card.Subtitle className="mb-2 text-muted">último Update - {obj.updated_at}</Card.Subtitle>
             <Card.Link href={obj.svn_url}>Visite o repositrio</Card.Link>
      </Card.Body>
    </Card>
    </div>
      );
    });
  }

  return (
    <div>
      {listaRepositorios}
    </div>
  );
}