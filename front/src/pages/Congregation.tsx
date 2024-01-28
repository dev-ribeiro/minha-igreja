import { Container } from "@components/Container";
import { useCongration } from "@hooks/useCongragation";
import Box from '@mui/material/Box'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Button from '@mui/material/Button';
import AddIcon from '@mui/icons-material/Add';
import Modal from '@mui/material/Modal';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';

export function Congregation() {
  const {
    registerCongretionForm,
    congregationsQuery,
    registerCongregation,
    registerCongregationModalVisibility,
    updateRegisterCongregationModalVisibility,
  } = useCongration();

  const { register, handleSubmit } = registerCongretionForm;

  const congregations = congregationsQuery?.response;

  const formattedCongregations = congregations && congregations.length > 0
    ? (
      <Box>
        <TableContainer>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Nome</TableCell>
                <TableCell>Contato</TableCell>
                <TableCell>Endereço</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {congregations.map(item => (
                <TableRow key={item.id}>
                  <TableCell>{item.nome}</TableCell>
                  <TableCell>{item.contato}</TableCell>
                  <TableCell>{item.endereco}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
    )
    : (
      <Box>
        <TableContainer>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Nome</TableCell>
                <TableCell>Contato</TableCell>
                <TableCell>Endereço</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              <TableRow>
                <TableCell colSpan={3}>
                  <Typography>Não há congregações a serem exibidas</Typography>
                </TableCell>
              </TableRow>
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
    );

  return (
    <>
      <Container>
        <Typography variant="h4" component="h1">Congregações</Typography>
        <div className="flex justify-end">
          <Button
            variant="text"
            startIcon={<AddIcon />}
            onClick={() => updateRegisterCongregationModalVisibility(true)}
          >
            Adicionar
          </Button>
        </div>
        {formattedCongregations}
      </Container>

      <Modal
        open={registerCongregationModalVisibility}
        onClose={() => updateRegisterCongregationModalVisibility(false)}
        className="flex items-center justify-center"
      >
        <div className="min-w-[50vw] flex flex-col p-3 bg-gray-100 rounded gap-3">
          <Typography variant="subtitle1">
            Cadastro de congregação
          </Typography>
          <form className="flex flex-col gap-4" onSubmit={handleSubmit(registerCongregation)}>
            <div className="flex flex-col">
              <label htmlFor="nome">Nome:</label>
              <TextField {...register("nome")} />
            </div>
            <div className="flex flex-col">
              <label htmlFor="contato">Contato:</label>
              <TextField {...register("contato")} />
            </div>
            <div className="flex flex-col">
              <label htmlFor="endereco">Endereço:</label>
              <TextField {...register("endereco")} />
            </div>
            <Button variant="contained" type="submit">
              CADASTRAR
            </Button>
          </form>
        </div>
      </Modal>
    </>
  );
}
