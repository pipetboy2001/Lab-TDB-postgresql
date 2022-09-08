<template>
  <div>
    <table>
      <tbody>
        <tr v-for="todos in todos" :key="todos.id">
          <td>{{ todos.id }}</td>
          <td>{{ todos.nombre }}</td>
          <td>{{ todos.descrip }}</td>
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
