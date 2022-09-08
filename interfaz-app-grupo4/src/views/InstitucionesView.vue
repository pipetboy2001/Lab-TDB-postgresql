<template>
  <div class="container">
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
            <button type="button" class="btn btn-danger">Borrar</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

// import axios from 'axios'
export default {
  data () {
    return {
      todos: null
    }
  },
  mounted () {
    console.log('hola monte')
    this.getTodos()
  },
  methods: {
    getTodos () {
      console.log('hola desde meto')
      axios.get('http://localhost:3000/instituciones')
        .then(response => {
          console.log(response.data)
          this.todos = response.data
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
}
</script>
