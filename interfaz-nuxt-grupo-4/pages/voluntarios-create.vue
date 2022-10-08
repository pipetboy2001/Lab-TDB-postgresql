<template>
    <div class="container" style="width:700px;">
      <h1>AÑADIR NUEVO VOLUNTARIO</h1>
      <form>
        <div class="form-group">
          <label for="nombre">Nombre</label>
          <input type="text" class="form-control" minlength="3" maxlength="100" id="nombre" v-model="form.nombre" required>
          <small id="nombreAyuda" class="form-text text-muted">Ingrese el nombre del voluntario.</small>
        </div>
        <div class="form-group">
          <label for="fecha">Fecha</label>
          <input type="text" class="form-control" minlength="10" maxlength="10" id="fecha" v-model="form.fecha" required>
          <small id="descripcionAyuda" class="form-text text-muted">La fecha de nacimineto con formato YYYY/MM/DD</small>
        </div>
        <button type="submit" class="btn btn-primary" v-on:click="crear()">CREAR</button>
        <button type="submit" class="btn btn-dark" v-on:click="cancelar()">CANCELAR</button>
      </form>
    </div>
  
  </template>
  
  <script>
  
  import axios from 'axios'
  
  export default {
    name: 'CREAR',
    data: function () {
      return {
        form: {
          nombre: '',
          fnacimiento: '',
          token: ''
        }
      }
    },
    methods: {
      crear () {
        this.form.token = localStorage.getItem('token')
        axios.post('http://localhost:3000/voluntarios', this.form)
          .then(data => {
            console.log(data)
            this.makeToast('Listo', 'Voluntario agregado', 'success')
          }).catch(error => {
            console.log(error)
            this.makeToast('Error', 'No se pudo agregar el voluntario', 'error')
          })
        this.$router.push('../voluntarios')
      },
      cancelar () {
        this.$router.push('/voluntarios')
      },
      makeToast (titulo, texto, tipo) {
        this.toastCount++
        this.$bvToast.toast(texto, {
          title: titulo,
          variant: tipo,
          autoHideDelay: 10000,
          appendToast: true
        })
      }
  
    }
  }
  </script>
  <style>
  
  </style>
  