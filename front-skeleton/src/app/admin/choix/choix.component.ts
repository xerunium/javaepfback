import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../services/admin.service";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-choix',
  standalone: true,
  templateUrl: './choix.component.html',
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class ChoixComponent implements OnInit {
  listChoix: any[] = [];
  categories: any[] = [];
  selectedChoix: any = {};
  showModal = false;
  showCreateModal = false;
  newChoix: any = { description: '', categorie: { nomCategorie: '' } };

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.loadChoix();
    this.loadCategories(); // Charger les catégories disponibles
  }

  loadCategories(): void {
    this.adminService.getCategory().subscribe(
      (data) => {
        this.categories = data;
      },
      (error) => {
        console.error('Erreur lors du chargement des catégories:', error);
      }
    );
  }


  trackById(index: number, choix: any): number {
    return choix.id;
  }

  openModal(choix: any): void {
    this.selectedChoix = {...choix};
    this.showModal = true;
  }

  // Fermer le modal
  closeModal(): void {
    this.showModal = false;
  }


  saveChanges(): void {
    if (this.selectedChoix) {
      // Appel à l'API pour sauvegarder les modifications
      this.adminService.updateChoix(this.selectedChoix.id, this.selectedChoix).subscribe(
        () => {
          // Mise à jour de la liste des choix
          const index = this.listChoix.findIndex(c => c.id === this.selectedChoix.id);
          if (index !== -1) {
            this.listChoix[index] = { ...this.selectedChoix };
          }
          this.closeModal();
        },
        (error) => {
          console.error('Erreur lors de la mise à jour du choix:', error);
        }
      );
    }
  }

  deleteChoix(id: number): void {
    this.adminService.deleteChoix(id).subscribe(
      () => {
        this.listChoix = this.listChoix.filter(choix => choix.id !== id);
      },
      (error) => {
        console.error('Erreur lors de la suppression du choix:', error);
      }
    );
  }

  // Méthode pour ouvrir le modal de création
  openCreateModal(): void {
    this.showCreateModal = true;
    this.newChoix = { description: '' };
  }

  // Méthode pour fermer le modal de création
  closeCreateModal(): void {
    this.showCreateModal = false;
  }

  // Méthode pour créer une nouvelle catégorie
  createChoix(): void {
    if (this.newChoix.description.trim()) {
      this.adminService.createChoix(this.newChoix).subscribe(
        (createdChoix) => {
          this.closeCreateModal(); // Ferme le modal
          this.loadChoix(); // Recharge les catégories après la fermeture
        },
        (error) => {
          console.error('Erreur lors de la création du choix:', error);
        }
      );
    } else {
      console.warn("Le nom du choix ne peut pas être vide.");
    }
  }


  loadChoix(): void {
    this.adminService.getChoix().subscribe(
      (data) => {
        console.log('Données reçues pour items:', data);
        this.listChoix = data.map(item => ({
          ...item,
          categorie: item.categorie || { nomCategorie: 'Catégorie inconnue' } // Définit une catégorie par défaut si elle est absente
        }));
      },
      (error) => {
        console.error('Erreur lors du chargement des items:', error);
      }
    );
  }
}
