subroutine MPI_Comm_spawn_multipleA(count, array_of_commands, array_of_argv, &
        array_of_maxprocs, array_of_info, &
        root, comm, intercomm, array_of_errcodes, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  character(len=*), dimension(*), intent(in) :: array_of_commands
  character(len=*), dimension(count,*), intent(in) :: array_of_argv
  integer, dimension(*), intent(in) :: array_of_maxprocs
  integer, dimension(*), intent(in) :: array_of_info
  integer, intent(in) :: root
  integer, intent(in) :: comm
  integer, intent(out) :: intercomm
  integer, dimension(*), intent(out) :: array_of_errcodes
  integer, intent(out) :: ierr

  call MPI_Comm_spawn_multiple(count, array_of_commands, array_of_argv, &
      array_of_maxprocs, array_of_info, root, comm, intercomm, &
      array_of_errcodes, ierr)
end subroutine MPI_Comm_spawn_multipleA

subroutine MPI_Comm_spawn_multipleN(count, array_of_commands, array_of_argv, &
        array_of_maxprocs, array_of_info, &
        root, comm, intercomm, array_of_errcodes, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  character(len=*), dimension(*), intent(in) :: array_of_commands
  double precision, intent(in) :: array_of_argv
  integer, dimension(*), intent(in) :: array_of_maxprocs
  integer, dimension(*), intent(in) :: array_of_info
  integer, intent(in) :: root
  integer, intent(in) :: comm
  integer, intent(out) :: intercomm
  integer, dimension(*), intent(out) :: array_of_errcodes
  integer, intent(out) :: ierr

  call MPI_Comm_spawn_multiple(count, array_of_commands, array_of_argv, &
      array_of_maxprocs, array_of_info, root, comm, intercomm, &
      array_of_errcodes, ierr)
end subroutine MPI_Comm_spawn_multipleN

