<template>
  <div>
    <h1>Instituciones CRUD</h1>
    <button type="button" class="btn btn-primary">Añadir</button>

    <!--Bootstrp table-->
    <table class="table table-striped table-dark table-bordered table-secondary">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">NOMBRE</th>
          <th scope="col">DESCRIPCION</th>
          <th scope="col">ACCIONES</th>
        </tr>
      </thead>
      <tbody>
          <tr scope="row" v-for="todos in todos" :key="todos.id">
            <td>{{ todos.id }}</td>
            <td>{{ todos.nombre }}</td>
            <td>{{ todos.descrip }}</td>
            <td> 
              <!--Botones-->
              <button type="button" class="btn btn-warning">Editar</button>
              <button type="button" class="btn btn-danger">Borrar</button> </td>
          </tr>
      </tbody>
    </table>



  </div>
</template>

<script>
import axios from 'axios'
export default{
  data(){
    return {
      todos:null
    }
  },
  mounted() {
    console.log('hola xd mounted')
    this.getTodos();
  },
  methods: {
    getTodos() {
      console.log('aca va el codgio de gets')
      axios
        .get('http://localhost:3000/instituciones')
        .then(response => {
          console.log(response)
          this.todos = response.data
        })
        .catch(error => {
          console.log(error)
        })
      }
    }
}
</script>

<style>
</style>
