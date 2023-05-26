import { Directive, ElementRef, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[background]',
})
export class BackgroundDirective implements OnInit {
  @Input()
  couleur!: string;
  // la directive douit connaitre deux choses :
  // Balise sur laquelle on postionne les directives --> on la retrouve grâce à ElementRef. Representera la balis sur laquell on positionne la direcive.
  // L'objet pour faire des modifications du DOM (on n'utilise pas le doc en Angular) : Renderer2. Injection d cet objet pour pouvoir l'utiliser.
  constructor(private renderer: Renderer2, private elementRef: ElementRef) {}

  ngOnInit(): void {
    this.renderer.setStyle(
      this.elementRef.nativeElement,
      'background-color',
      this.couleur
    );
  }
}
