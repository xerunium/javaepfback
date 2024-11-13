import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../services/admin.service";
import {CommonModule} from "@angular/common";
import {RouterOutlet} from "@angular/router";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-categories',
  standalone: true,
  templateUrl: './categories.component.html',
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class Categories implements OnInit {
  categories: any[] = [];
  selectedCategory: any = {};
  showModal = false;
  showCreateModal = false;
  newCategory: any = { nomCategorie: '' };

  constructor(private adminService: AdminService) {
  }

  ngOnInit(): void {
    // Appel du service pour récupérer les catégories
    this.adminService.getCategory().subscribe(
      (data) => {
        this.categories = data;
      },
      (error) => {
        console.error('Erreur lors du chargement des catégories:', error);
      }
    );
  }

  // Méthode pour suivre les catégories par ID (optimisation de *ngFor)
  trackById(index: number, category: any): number {
    return category.id;
  }

  // Ouvrir le modal pour modifier une catégorie
  openModal(category: any): void {
    this.selectedCategory = {...category};
    this.showModal = true;
  }

  // Fermer le modal
  closeModal(): void {
    this.showModal = false;
  }

  // Enregistrer les modifications pour une catégorie
  saveChanges(): void {
    if (this.selectedCategory) {
      // Appel à l'API pour sauvegarder les modifications
      this.adminService.updateCategory(this.selectedCategory.id, this.selectedCategory).subscribe(
        () => {
          // Mise à jour de la liste des catégories
          const index = this.categories.findIndex(c => c.id === this.selectedCategory.id);
          if (index !== -1) {
            this.categories[index] = this.selectedCategory;
          }
          this.closeModal();
        },
        (error) => {
          console.error('Erreur lors de la mise à jour de la catégorie:', error);
        }
      );
    }
  }

  // Supprimer une catégorie
  deleteCategory(id: number): void {
    this.adminService.deleteCategory(id).subscribe(
      () => {
        this.categories = this.categories.filter(category => category.id !== id);
      },
      (error) => {
        console.error('Erreur lors de la suppression de la catégorie:', error);
      }
    );
  }

  // Méthode pour ouvrir le modal de création
  openCreateModal(): void {
    this.showCreateModal = true;
    this.newCategory = { nomCategorie: '' };
  }

  // Méthode pour fermer le modal de création
  closeCreateModal(): void {
    this.showCreateModal = false;
  }

  // Méthode pour créer une nouvelle catégorie
  createCategory(): void {
    if (this.newCategory.nomCategorie.trim()) {
      this.adminService.createCategory(this.newCategory).subscribe(
        (createdCategory) => {
          this.closeCreateModal(); // Ferme le modal
          this.loadCategories(); // Recharge les catégories après la fermeture
        },
        (error) => {
          console.error('Erreur lors de la création de la catégorie:', error);
        }
      );
    } else {
      console.warn("Le nom de la catégorie ne peut pas être vide.");
    }
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

}
